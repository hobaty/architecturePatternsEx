package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumbersViewModel extends ViewModel {
    MutableLiveData<Integer> numbersMutableLiveData = new MutableLiveData<>();

   private NumberModel getNumbers()
    {
        return new DataBase().getNumbers();
    }

    int mulTwoNumbers ()
    {
        return getNumbers().getFirstNum() * getNumbers().getSecondNum();
    }
    void getMulResult ()
    {
        numbersMutableLiveData.setValue(mulTwoNumbers());
    }
}
