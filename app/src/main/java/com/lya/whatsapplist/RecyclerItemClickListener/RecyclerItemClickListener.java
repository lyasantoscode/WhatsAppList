package com.lya.whatsapplist.RecyclerItemClickListener;

import android.content.Context;

import android.view.GestureDetector;

import android.view.MotionEvent;

import android.view.View;

import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;

    GestureDetector mGestureDetector;

    @Override

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View childView = rv.findChildViewUnder(e.getX(), e.getY());

        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {

            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));

            return true;

        }

        return false;

    }

    @Override

    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnItemClickListener extends AdapterView.OnItemClickListener {

        public void onItemClick(View view, int position);

        public void onLongItemClick(View view, int position);

    }

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {

        mListener = listener;

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override

            public boolean onSingleTapUp(MotionEvent e) {

                return true;

            }

            @Override

            public void onLongPress(MotionEvent e) {

                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if (child != null && mListener != null) {

                    mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));

                }

            }

        });

    }

}

//essa forma é mais recomendada, onde vai se encaixar na maioria
//essa clase foi pegar do proprio google, não se preocupe como foi criado. Que vai definir o clicklongo por exemplo,
//vai definir o onTouchEvent e tambem vamos ter o onInterceptTouchEvent
//essa é uma das formas, mas também tem outras, só pesquisar na net "como colocar o click em itens da recyclerview, vai achar diversas formas