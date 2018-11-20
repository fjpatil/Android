package com.example.fjpatil.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentA extends Fragment implements View.OnClickListener {


    private loadFragment mListener;
    private Button button;
    private EditText nameEditText;
    private View mRootView;
    private FragmentB mFragmentB;
    private Model model;



    public FragmentA() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(mRootView==null) {
            mRootView = inflater.inflate(R.layout.fragmenta_layout, container, false);

        }

        model=new Model();
        getViews();
        button.setOnClickListener(this);
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        nameEditText.setText("");
    }

    @Override
    public void onPause() {
        super.onPause();
        nameEditText.setText("");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (loadFragment) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void getViews(){

        button= (Button) mRootView.findViewById(R.id.button);
        nameEditText= (EditText) mRootView.findViewById(R.id.nameEdiText);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button:
                String name=nameEditText.getText().toString();
                Model myModel=new Model();
                myModel.setName(name);
                Bundle bundle =new Bundle();
                bundle.putSerializable("Name", myModel);
                mListener.loadFragments(Constants.FRAGMENT_B,bundle);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
