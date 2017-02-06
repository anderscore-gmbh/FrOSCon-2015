package com.anderscore.frosconsample;

import java.util.List;

/**
 * Created by max on 21.08.2015.
 */
public interface IView {
    void updateList();

    void updateList(List<String> data);

    void updateDaveCount(int count);
}
