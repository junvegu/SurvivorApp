package com.cerezaconsulting.coreproject.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.core.BaseFragment;
import com.cerezaconsulting.coreproject.presentation.activities.ExampleActivity;
import com.cerezaconsulting.coreproject.presentation.contracts.MainContract;
import com.cerezaconsulting.coreproject.utils.ProgressDialogCustom;

import butterknife.ButterKnife;

/**
 * Created by junior on 27/08/16.
 */
public class InputPayFragment extends BaseFragment  implements  MainContract.View{

    private static final String TAG = ExampleActivity.class.getSimpleName();


    private MainContract.Presenter mPresenter;

    private ProgressDialogCustom mProgressDialogCustom;



    public InputPayFragment() {
        // Requires empty public constructor
    }

    public static InputPayFragment newInstance() {
        return new InputPayFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_init_sald, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");


    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String msg) {
        ((BaseActivity) getActivity()).showMessage(msg);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }


    @Override
    public boolean isActive() {
        return isAdded();
    }

}
