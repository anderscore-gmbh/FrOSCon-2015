package com.anderscore.frosconsample;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends ListActivity implements IView {


    private TextView DaveCount;
    private ArrayAdapter<String> adapter;

    private IPresenter presenter;

    public MainActivity() {
        presenter = new Presenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

        presenter.init(this);
    }

    private void initViews() {
        setContentView(R.layout.activity_main);

        DaveCount = new TextView(this);
        DaveCount.setTextAppearance(this, R.style.Base_TextAppearance_AppCompat_Display1);
        getListView().addHeaderView(DaveCount);

        Button addButton = new Button(this);
        addButton.setTextAppearance(this, R.style.TextAppearance_AppCompat_Button);
        addButton.setText("Add Dave");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addDaveToList();
            }
        });
        getListView().addFooterView(addButton);


    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateList(List<String> data) {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }

    @Override
    public void updateDaveCount(int count) {
        DaveCount.setText("Dave kommt " + count + " mal vor!");
    }

    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }


}
