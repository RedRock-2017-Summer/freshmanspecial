package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Presenter;

import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantFrg;
import com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Interface.IElegantPre;

/**
 * Created by Anriku on 2017/8/10.
 */

public class ElegantPresenter implements IElegantPre {

    private IElegantFrg iElegantFrg;

    public ElegantPresenter(IElegantFrg iElegantFrg) {
        this.iElegantFrg = iElegantFrg;
    }
}
