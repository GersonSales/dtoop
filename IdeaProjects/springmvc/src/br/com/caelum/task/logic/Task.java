package br.com.caelum.task.logic;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Created by gersonsales on 11/01/17.
 */
public class Task {
    private Long id;

    @NotNull()
    private String description;

    private boolean checked;
    private Calendar checkDate;

}
