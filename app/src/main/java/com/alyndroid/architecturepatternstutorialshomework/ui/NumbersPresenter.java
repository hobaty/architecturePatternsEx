package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.repo.model.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.repo.DataBase;

public class NumbersPresenter {
    INumbers numbers ;

    public NumbersPresenter(INumbers numbers) {
        this.numbers = numbers;
    }

    NumberModel getNumbers (){
        return new DataBase().getNumbers();
    }

    int divTowNumbers()
    {
        return getNumbers().getFirstNum() / getNumbers().getSecondNum();
    }

    void getDivResult()
    {
        numbers.onGetDivResult(divTowNumbers());
    }
}
