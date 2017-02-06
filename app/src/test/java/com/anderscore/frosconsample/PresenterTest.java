package com.anderscore.frosconsample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by max on 21.08.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    Presenter presenter;

    @Mock
    IView view;

    @Mock
    Model model;

    @Before
    public void setUp() {
        presenter = new Presenter();
        presenter.setModel(model);

    }

    @Test
    public void shouldInitCorrectly() {
        List<String> data = Model.getInstance().getData();
        when(model.getData()).thenReturn(data);


        presenter.init(view);

        verify(view).updateList(data);
        verify(view).updateDaveCount(2);
    }

    @Test
    public void shouldaddDaveToListAndNotifyView() {
        final List<String> data = Model.getInstance().getData();
        when(model.getData()).thenReturn(data);
        presenter.init(view);

        presenter.addDaveToList();

        verify(model).addItem("Dave");
        verify(view).updateList();
        verify(view,times(2)).updateDaveCount(any(Integer.class));
    }
}