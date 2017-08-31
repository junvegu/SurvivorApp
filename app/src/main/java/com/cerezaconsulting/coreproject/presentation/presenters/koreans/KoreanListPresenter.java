package com.cerezaconsulting.coreproject.presentation.presenters.koreans;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.cerezaconsulting.coreproject.data.local.SessionManager;
import com.cerezaconsulting.coreproject.data.model.KoreanModelEntity;
import com.cerezaconsulting.coreproject.presentation.contracts.MainContract;
import com.cerezaconsulting.coreproject.presentation.contracts.koreans.KoreanListContract;

import java.util.ArrayList;

/**
 * Created by manu on 08/08/16.
 */
public class KoreanListPresenter implements KoreanListContract.Presenter{

    private final KoreanListContract.View mView;
    private boolean mFirstLoad = false;


    public KoreanListPresenter(@NonNull KoreanListContract.View view,
                               Context context) {
        this.mView = view;
        this.mView.setPresenter(this);
    }


    @Override
    public void start() {

        loadKoreans();
    }



    @Override
    public void loadKoreans() {

        mView.setLoadingIndicator(true);




        ArrayList<KoreanModelEntity> koreanModelEntities =  new ArrayList<>();
        koreanModelEntities.add(new KoreanModelEntity("Rosé","https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg" ,"Roseanne Park mejor conocida como Rosé es una cantante, modelo, bailarina y MC australiana de origen surcoreano. Es miembro del grupo femenino BLACKPINK formado por YG Entertainment en 2016. Siendo la vocalista principal."));
        koreanModelEntities.add(new KoreanModelEntity("Jennie","https://i.pinimg.com/736x/d6/c0/dd/d6c0dd04db2cd750438ad2bd8c88f624--pink-live-pink-style.jpg" ," Jennie Kim mejor conocida como Jennie es una cantante, rapera y bailarina surcoreana. Es miembro del grupo femenino BLACKPINK formado por YG Entertainment en 2016. Siendo rapera principal y segunda bailarina"));
        koreanModelEntities.add(new KoreanModelEntity("Jisoo","http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg" ,"Kim Ji Soo mejor conocida por su nombre monónimo Jisoo es una cantante, bailarina, actriz, modelo y MC surcoreana. Es integrante del grupo femenino BLACKPINK formado por YG Entertainment en 2016. Siendo Visual y Segunda Vocalista"));
        koreanModelEntities.add(new KoreanModelEntity("Lisa","https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es" ,"Lalisa Manoban conocida por su nombre artístico Lisa es una rapera, cantante y bailarina tailandesa. Ella es integrante del grupo femenino Black Pink desde 2016 bajo YG Entertainment siendo rapera secundaria y bailarina principal"));

        mView.setLoadingIndicator(false);

        mView.showListKoreans(koreanModelEntities);


       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


    }
}
