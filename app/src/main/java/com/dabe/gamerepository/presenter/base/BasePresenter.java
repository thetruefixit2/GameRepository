package com.dabe.gamerepository.presenter.base;

import com.dabe.gamerepository.model.IDataManager;
import com.dabe.gamerepository.view.base.IBaseView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Daniil Belevtsev on 12.01.2017 0:31.
 * Project: GameRepository; Skype: pandamoni1
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    protected T view;

    @Inject
    protected IDataManager dataManager;

    @Inject
    protected CompositeSubscription compositeSubscription; // this is for clear rxJava subscribers.

    public BasePresenter() {
    }

    protected void addSubscriber(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void onStop() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }

    protected T getView() {
        return view;
    }

    protected void setView(T view) {
        this.view = view;
    }
}
