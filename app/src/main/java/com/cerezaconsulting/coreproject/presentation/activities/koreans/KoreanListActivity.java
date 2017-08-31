package com.cerezaconsulting.coreproject.presentation.activities.koreans;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.presentation.fragments.ExampleFragment;
import com.cerezaconsulting.coreproject.presentation.fragments.koreans.KoreanListFragment;
import com.cerezaconsulting.coreproject.presentation.presenters.ExamplePresenter;
import com.cerezaconsulting.coreproject.presentation.presenters.koreans.KoreanListPresenter;
import com.cerezaconsulting.coreproject.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 31/08/17.
 */

public class KoreanListActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);

        toolbar.setTitle("BlackPink");






        KoreanListFragment fragment = (KoreanListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = KoreanListFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        new KoreanListPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
