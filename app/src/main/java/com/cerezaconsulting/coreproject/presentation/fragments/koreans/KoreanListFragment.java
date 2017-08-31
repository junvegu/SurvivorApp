package com.cerezaconsulting.coreproject.presentation.fragments.koreans;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.core.BaseActivity;
import com.cerezaconsulting.coreproject.core.BaseFragment;
import com.cerezaconsulting.coreproject.core.ScrollChildSwipeRefreshLayout;
import com.cerezaconsulting.coreproject.data.model.KoreanModelEntity;
import com.cerezaconsulting.coreproject.presentation.adapters.KoreanAdapter;
import com.cerezaconsulting.coreproject.presentation.contracts.koreans.KoreanListContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 31/08/17.
 */

public class KoreanListFragment extends BaseFragment implements KoreanListContract.View {


    @BindView(R.id.listItems)
    RecyclerView listItems;
    @BindView(R.id.noItems)
    LinearLayout noItems;
    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout refreshLayout;


    private KoreanListContract.Presenter mPresenter;
    private KoreanAdapter mKoreanAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    public KoreanListFragment() {
        // Requires empty public constructor
    }

    public static KoreanListFragment newInstance() {
        return new KoreanListFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_korean, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Instanciar todo

        refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark),
                ContextCompat.getColor(getActivity(), R.color.red)
        );
        // Set the scrolling view in the custom SwipeRefreshLayout.
        refreshLayout.setScrollUpChild(listItems);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mPresenter.loadKoreans();

            }
        });



        mKoreanAdapter = new KoreanAdapter(new ArrayList<KoreanModelEntity>(), getContext());
        mLinearLayoutManager = new LinearLayoutManager(getContext());

        listItems.setAdapter(mKoreanAdapter);
        listItems.setLayoutManager(mLinearLayoutManager);
    }


    @Override
    public void showListKoreans(ArrayList<KoreanModelEntity> koreanModelEntities) {


        showErrorMessage("Carga Exitosa");

        if (koreanModelEntities.size() > 0) {
            mKoreanAdapter.setItems(koreanModelEntities);
            noItems.setVisibility(View.GONE);
        } else {
            noItems.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showDetailKoreanItem(KoreanModelEntity koreanModelEntity) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(KoreanListContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }

        // Make sure setRefreshing() is called after the layout is done with everything else.
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(active);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
