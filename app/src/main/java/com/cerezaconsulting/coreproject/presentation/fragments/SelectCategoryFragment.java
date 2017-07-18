package com.cerezaconsulting.coreproject.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.core.BaseFragment;
import com.cerezaconsulting.coreproject.data.model.CategoryEntity;
import com.cerezaconsulting.coreproject.presentation.activities.ExampleActivity;
import com.cerezaconsulting.coreproject.presentation.adapters.CategoriesAdapter;
import com.cerezaconsulting.coreproject.presentation.contracts.MainContract;
import com.cerezaconsulting.coreproject.utils.ProgressDialogCustom;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 27/08/16.
 */
public class SelectCategoryFragment extends BaseFragment implements MainContract.View {

    private static final String TAG = ExampleActivity.class.getSimpleName();
    @BindView(R.id.listItems)
    RecyclerView listItems;
    @BindView(R.id.listContainer)
    LinearLayout listContainer;
    @BindView(R.id.noItems)
    LinearLayout noItems;
    @BindView(R.id.clinic_container)
    RelativeLayout clinicContainer;


    private MainContract.Presenter mPresenter;
    private ProgressDialogCustom mProgressDialogCustom;
    private CategoriesAdapter mCategoriesAdapter;
    private LinearLayoutManager mLinearLayout;


    public SelectCategoryFragment() {
        // Requires empty public constructor
    }

    public static SelectCategoryFragment newInstance() {
        return new SelectCategoryFragment();
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
        View root = inflater.inflate(R.layout.fragment_list_categories, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");
        mCategoriesAdapter = new CategoriesAdapter(CategoryEntity.categoryEntities(), getContext());
        mLinearLayout = new LinearLayoutManager(getContext());
        mLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);

        listItems.setLayoutManager(mLinearLayout);
        listItems.setAdapter(mCategoriesAdapter);
        noItems.setVisibility(View.GONE);


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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
