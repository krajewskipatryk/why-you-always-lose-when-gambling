package com.gamblingmethods.test.gambler.Roulette.Api;

import com.gamblingmethods.test.gambler.Roulette.Api.Model.Color;
import com.gamblingmethods.test.gambler.Roulette.Api.Model.Result;
import com.gamblingmethods.test.gambler.Roulette.Api.Model.RouletteBet;
import com.gamblingmethods.test.gambler.Roulette.Api.Model.RouletteResult;

import java.util.Random;

public class RouletteSimulator {
    private int generateNumber() {
        Random random = new Random();
        return random.nextInt(37);
    }

    private Color getColor(int number) {
        if (number == 0) {
            return Color.GREEN;
        }

        if ((number >= 1 && number <= 10) || (number >= 19 && number <= 28)) {
            if (number % 2 == 0)
                return Color.BLACK;
            else
                return Color.RED;
        }

        if ((number >= 11 && number <= 18) || (number >= 29 && number <= 36)) {
            if (number % 2 == 0)
                return Color.RED;
            else
                return Color.BLACK;
        }

        return null;
    }

    private Integer calculatePrizeNumberBid(Integer bidValue) {
        return bidValue * 35;
    }

    private Integer calculatePrizeColorBid(Integer bidValue, Color color) {
        if (color == Color.BLACK || color == Color.RED) {
            return bidValue * 2;
        } else {
            return bidValue * 35;
        }
    }

    public RouletteResult playRoulette(RouletteBet bet) {
        int number = this.generateNumber();
        Color color = this.getColor(number);

        if (bet. && bet.getNumber() == number) {
            return new RouletteResult(Result.WIN, this.calculatePrizeNumberBid(bet.getBid()));
        }

        if (bet.getColor() != null && color.equals(bet.getColor())) {
            return new RouletteResult(Result.WIN, this.calculatePrizeColorBid(bet.getBid(), bet.getColor()));
        }

        return new RouletteResult(Result.LOSE, 0);
    }
}
