package com.anderscore.frosconsample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by max on 22.08.2015.
 *
 * Hinweis: Beim Starten dieses Tests kann es sein das Robolectic das AndroidManifest nicht findet
 * dies kann man entweder beheben, indem man den RobolecticGradleTestrunner extended und das Manifest
 * dort setzt oder indem man in der runn Confid \app zum Working Directory hinzufügt.
 * Um den
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "app/src/main/AndroidManifest.xml")
public class MainActivityItTest {

    @Mock
    IPresenter presenter;

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ActivityController controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = (MainActivity) controller.get();
        mainActivity.setPresenter(presenter);
        controller.create().start().resume().visible();
    }

    @Test
    public void shouldUpdateListAdapterOnUpdateListInititally() {

        mainActivity.updateList(Model.getInstance().getData());
        assertThat(mainActivity.getListView().getCount(), is(equalTo(7 + 2)));//+2 for header and footer view
    }

    @Test
    public void shouldInitPresenter() {
        verify(presenter).init(mainActivity);
    }

}
