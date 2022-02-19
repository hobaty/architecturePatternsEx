package com.alyndroid.architecturepatternstutorialshomework.repo;

import com.alyndroid.architecturepatternstutorialshomework.repo.model.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
