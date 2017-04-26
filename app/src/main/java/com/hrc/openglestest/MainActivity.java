package com.hrc.openglestest;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建GLSurfaceView对象
        GLSurfaceView glSurfaceView=new GLSurfaceView(this);
        //为GLSurfaceView制定TriangleSurfaceView对象
        glSurfaceView.setRenderer(new MyRender());
        //设置当前显示的视图
        setContentView(glSurfaceView);
    }
}
