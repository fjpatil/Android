package com.example.fjpatil.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentB extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private loadFragment mListener;
    private View mRootView;
    private Model model;
    private TextView mTextview;
    private Button button;
    private Bundle mBundle;



    public FragmentB() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                 mRootView = inflater.inflate(R.layout.fragmentb_layout, container, false);

        getViews();
        mBundle=this.getArguments();
        Model Mymodel= (Model) mBundle.getSerializable("Name");
        String name=mBundle.getString("Model");
        button.setOnClickListener(this);

        mTextview.setText(Mymodel.getName());


        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int  uri) {
        if (mListener != null) {
            mListener.loadFragments(uri);
        }
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
       mTextview= (TextView) mRootView.findViewById(R.id.nameTextView);
       button= (Button) mRootView.findViewById(R.id.backButton);
   }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.backButton:
                mListener.loadFragments(Constants.FRAGMENT_A);
                //onButtonPressed(Constants.FRAGMENT_A);
                break;
            default:
                break;
        }
    }
}
