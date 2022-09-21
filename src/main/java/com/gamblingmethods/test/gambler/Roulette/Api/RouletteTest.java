package com.gamblingmethods.test.gambler.Roulette.Api;

import com.gamblingmethods.test.gambler.Roulette.Api.Model.RouletteRequestColorBet;
import com.gamblingmethods.test.gambler.Roulette.Api.Model.TestResults;

public interface RouletteTest {
    TestResults doubleBidOnLoseMethod(RouletteRequestColorBet initialBetValue);
}
