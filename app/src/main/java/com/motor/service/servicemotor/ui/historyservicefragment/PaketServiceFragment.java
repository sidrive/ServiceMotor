package com.motor.service.servicemotor.ui.historyservicefragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.motor.service.servicemotor.R;
import com.motor.service.servicemotor.data.adapter.AdapterService;
import com.motor.service.servicemotor.data.model.Motor;
import com.motor.service.servicemotor.data.model.Service;
import com.motor.service.servicemotor.data.remote.CategoryService;
import com.motor.service.servicemotor.data.remote.UserService;
import com.motor.service.servicemotor.ui.historyservice.HistoryServiceActivity;

import java.util.ArrayList;
import java.util.List;

import static io.fabric.sdk.android.Fabric.TAG;


public class PaketServiceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    AdapterService adapterService;
    Motor motor = null;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PaketServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PaketServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaketServiceFragment newInstance(String param1, String param2) {
        PaketServiceFragment fragment = new PaketServiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: "+((HistoryServiceActivity)getActivity()).motorr());
        if (getArguments() != null) {
            motor = (Motor) getArguments().getSerializable("motor");
//            Log.e(TAG, "onCreate: " + motor);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paketservice, container, false);
        RecyclerView lsservice = (RecyclerView) view.findViewById(R.id.lsservice);

            initRecycleView(lsservice);
            getService(lsservice);
//        if (getArguments() != null) {
//            Motor motor = (Motor) getArguments().getSerializable("motor");
////            Log.e(TAG, "onCreate: "+motor.getIdmotor());
//
////            getService(motor,lsservice);
//        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: "+getContext());
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void initRecycleView(RecyclerView lsservice) {

        lsservice.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        lsservice.addItemDecoration(
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lsservice.setLayoutManager(new LinearLayoutManager(getActivity()));
//        lsbarang.setLayoutManager(layoutManager);
        lsservice.setNestedScrollingEnabled(false);

    }

    public void getService(RecyclerView lsservice){
        Motor motor = ((HistoryServiceActivity)getActivity()).motorr();

        CategoryService categoryService = new CategoryService();
            categoryService.getServicePaket(motor.getIdmotor()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    List<Service> listService = new ArrayList<Service>();
//                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Service service = postSnapshot.getValue(Service.class);
                        Log.e("PaketService", "onDataChange: " + postSnapshot.getValue());
                        listService.add(service);
//                    Log.e("MainPresenter", "onDataChange: " + listMotor);
                    }

                    initListService(listService, lsservice);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
    }

    public void initListService(List<Service> listService, RecyclerView lsservice){
        Log.e(TAG, "initListService: "+listService );
        adapterService = new AdapterService((ArrayList<Service>) listService,getContext(), (HistoryServiceActivity) getActivity());
        adapterService.UpdateService(listService);
        lsservice.setAdapter(adapterService);
        Log.e(TAG, "initListService: "+adapterService );
    }
}
