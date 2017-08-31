package com.cerezaconsulting.coreproject.presentation.contracts.koreans;

import com.cerezaconsulting.coreproject.core.BasePresenter;
import com.cerezaconsulting.coreproject.core.BaseView;
import com.cerezaconsulting.coreproject.data.model.KoreanModelEntity;

import java.util.ArrayList;

/**
 * Especifica el contrato entre la vista y el presentador para logueo
 */
public interface KoreanListContract {

    interface View extends BaseView<Presenter> {


        void showListKoreans(ArrayList<KoreanModelEntity> koreanModelEntities);

        void showDetailKoreanItem(KoreanModelEntity koreanModelEntity);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {


        void loadKoreans();


    }
}
