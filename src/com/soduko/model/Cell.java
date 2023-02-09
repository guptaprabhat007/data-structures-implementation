package com.soduko.model;

import java.util.HashSet;

public class Cell {

    private int value;
    private boolean filled;
    private HashSet<Integer> tried;
}
