package com.cerezaconsulting.coreproject.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.presentation.fragments.ExampleFragment;
import com.cerezaconsulting.coreproject.presentation.fragments.SelectCategoryFragment;
import com.cerezaconsulting.coreproject.presentation.presenters.ExamplePresenter;
import com.cerezaconsulting.coreproject.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelecteCategoriesActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);

        toolbar.setTitle("Selecciona las categorias");

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        SelectCategoryFragment fragment = (SelectCategoryFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = SelectCategoryFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        //new ExamplePresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
