package com.gamblingmethods.test.gambler.Roulette.Api;

import com.gamblingmethods.test.gambler.Roulette.Api.Model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouletteTestImpl implements RouletteTest {
    @Override
    public TestResults doubleBidOnLoseMethod(RouletteRequestColorBet initialBetValue) {
        RouletteBetDto bet = new RouletteBetDto(initialBetValue.bid(), initialBetValue.color());
        RouletteSimulator roulette = new RouletteSimulator();
        List<RouletteResult> results = new ArrayList<>();

        int currentBid = 1;
        Result lastResult = Result.WIN;

        for (int i = 0; i < initialBetValue.testCount(); i++) {
            if (lastResult.equals(Result.WIN))
                currentBid = 1;
            else
                currentBid = currentBid * 2;

            if (bet.getCurrentBalance() - currentBid <= 0)
                return new TestResults(this.calculateWins(results), this.calculateLoses(results), bet.getCurrentBalance());

            RouletteResult result = (roulette.playRoulette(new RouletteBet(currentBid, initialBetValue.number(), bet.getBetColor())));
            bet.setCurrentBalance(bet.getCurrentBalance() - currentBid + result.prize());

            results.add(result);
        }

        return new TestResults(this.calculateWins(results), this.calculateLoses(results), bet.getCurrentBalance());
    }

    private int calculateWins(List<RouletteResult> results) {
        return results.stream()
                .filter(betResult -> betResult.result() == Result.WIN)
                .toList()
                .size();
    }

    private int calculateLoses(List<RouletteResult> results) {
        return results.stream()
                .filter(betResult -> betResult.result() == Result.LOSE)
                .toList()
                .size();
    }
}
