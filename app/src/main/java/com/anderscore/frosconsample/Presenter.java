package com.anderscore.frosconsample;

import java.util.Collections;

/**
 * Created by max on 21.08.2015.
 */
public class Presenter implements IPresenter {

    private static final String DAVE = "Dave";

    IView view;
    Model model;

    public Presenter() {
        model = Model.getInstance();
    }

    @Override
    public void addDaveToList() {
        model.addItem(DAVE);
        presentList();
    }

    @Override
    public void init(IView view) {
        this.view = view;
        view.updateList(model.getData());
        presentCount();
    }

    private void presentCount() {
        int count = Collections.frequency(model.getData(), DAVE);
        view.updateDaveCount(count);
    }

    private void presentList() {
        view.updateList();
        presentCount();
    }

    /**
     * @param model Mocked Model
     */
    public void setModel(Model model) {
        this.model = model;
    }
}
