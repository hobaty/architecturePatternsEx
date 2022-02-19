package com.alyndroid.architecturepatternstutorialshomework.viewmodel;

import com.alyndroid.architecturepatternstutorialshomework.repo.model.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.repo.DataBase;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumbersViewModel extends ViewModel {
    public MutableLiveData<Integer> numbersMutableLiveData = new MutableLiveData<>();

   private NumberModel getNumbers()
    {
        return new DataBase().getNumbers();
    }

    int mulTwoNumbers ()
    {
        return getNumbers().getFirstNum() * getNumbers().getSecondNum();
    }
    public void getMulResult()
    {
        numbersMutableLiveData.setValue(mulTwoNumbers());
    }
}
