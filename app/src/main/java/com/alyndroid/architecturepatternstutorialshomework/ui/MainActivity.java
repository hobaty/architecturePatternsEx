package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.repo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.repo.model.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.viewmodel.NumbersViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,INumbers {

    DataBase dataBase ;
    NumbersPresenter presenter;
    NumbersViewModel numbersViewModel;
    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);
        dataBase  = new DataBase();
        presenter = new NumbersPresenter(this);
        numbersViewModel = new ViewModelProvider(this).get(NumbersViewModel.class);
        numbersViewModel.numbersMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer s) {
                binding.mulResultTextView.setText(String.valueOf(s));
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            // apply MVC architecture
            case R.id.plus_button:
            {
                viewAddResult();
                break;
            }
            // apply MVP architecture
            case R.id.div_button:
            {
                presenter.getDivResult();
                break;
            }
            // apply MVVM architecture
            case R.id.mul_button:
            {
                numbersViewModel.getMulResult();
                break;
            }
        }
    }

    NumberModel getNumbersFromDataBase()
    {
      return dataBase.getNumbers();
    }

    int addTwoNumbers()
    {
        NumberModel numberModel = getNumbersFromDataBase();
        return numberModel.getFirstNum() + numberModel.getSecondNum();
    }

    void viewAddResult()
    {
        binding.plusResultTextView.setText(String.valueOf(addTwoNumbers() ) );
    }

    // MVP
    @Override
    public void onGetDivResult(int i) {
        binding.divResultTextView.setText(String.valueOf(i));
    }
}
