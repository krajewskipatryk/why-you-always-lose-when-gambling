package com.gamblingmethods.test.gambler.Roulette.Api.Model;

import lombok.Data;

@Data
public class RouletteBetDto {
    Integer currentBalance;
    Color betColor;
    Integer betNumber;

    public RouletteBetDto(Integer currentBalance, Integer betNumber) {
        this.currentBalance = currentBalance;
        this.betNumber = betNumber;
    }

    public RouletteBetDto(Integer currentBalance, Color betColor) {
        this.currentBalance = currentBalance;
        this.betColor = betColor;
    }

    public RouletteBetDto(Integer currentBalance, Color betColor, Integer betNumber) {
        this.currentBalance = currentBalance;
        this.betColor = betColor;
        this.betNumber = betNumber;
    }
}
