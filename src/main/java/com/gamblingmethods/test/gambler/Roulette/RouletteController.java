package com.gamblingmethods.test.gambler.Roulette;

import com.gamblingmethods.test.gambler.Roulette.Api.Model.RouletteRequestColorBet;
import com.gamblingmethods.test.gambler.Roulette.Api.Model.TestResults;
import com.gamblingmethods.test.gambler.Roulette.Api.RouletteTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gambling")
@RequiredArgsConstructor
public class RouletteController {
    private final RouletteTest rouletteTest;

    @GetMapping(path = "/doubling")
    public TestResults checkDoubleValueMethod(@RequestBody RouletteRequestColorBet colorBet) {
        return rouletteTest.doubleBidOnLoseMethod(colorBet);
    }
}
