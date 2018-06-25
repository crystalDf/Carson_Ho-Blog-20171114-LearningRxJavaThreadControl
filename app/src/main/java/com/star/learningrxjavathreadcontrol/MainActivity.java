package com.star.learningrxjavathreadcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "被观察者Observable的工作线程是: " +
//                            Thread.currentThread().getName());
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                        Log.d(TAG, "观察者Observer的工作线程是: " +
//                                Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    Log.d(TAG, "被观察者Observable的工作线程是: " +
//                            Thread.currentThread().getName());
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                        Log.d(TAG, "观察者Observer的工作线程是: " +
//                                Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });

        Observable
                .create((ObservableOnSubscribe<Integer>) emitter -> {

                    Log.d(TAG, "被观察者Observable的工作线程是: " +
                            Thread.currentThread().getName());

                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(integer -> Log.d(TAG, "第一次观察者Observer的工作线程是: " +
                        Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .doOnNext(integer -> Log.d(TAG, "第二次观察者Observer的工作线程是: " +
                        Thread.currentThread().getName()))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                        Log.d(TAG, "观察者Observer的工作线程是: " +
                                Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }
}
