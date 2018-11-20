package com.example.fjpatil.fragmentexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements loadFragment {

    private FragmentManager mFragmentManager;
    private Fragment mFragmentA;
    private Fragment mFragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        mFragmentManager = getFragmentManager();
        loadFragments(Constants.FRAGMENT_A);


    }


    private void loadFragment(Fragment fragment, String tag) {
        mFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment, tag).commit();

    }

    @Override
    public void loadFragments(int fragment) {

        System.out.println("loadFragment: " + fragment);
        switch (fragment) {
            case Constants.FRAGMENT_A:
                loadFragment(mFragmentA, Constants.FRAGMENTA);
                break;
            case Constants.FRAGMENT_B:
                loadFragment(mFragmentB, Constants.FRAGMENTB);
                break;
            default:
                break;


        }
    }

    @Override
    public void loadFragments(int fragment, Bundle bundle) {
        switch (fragment) {
            case Constants.FRAGMENT_A:
                mFragmentA.setArguments(bundle);
                loadFragment(mFragmentA, Constants.FRAGMENTA);
                break;
            case Constants.FRAGMENT_B:
                mFragmentB.setArguments(bundle);
                loadFragment(mFragmentB, Constants.FRAGMENTB);
                break;
        }
    }


}
