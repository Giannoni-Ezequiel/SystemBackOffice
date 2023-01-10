package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public enum Estado {
    NUEVO,
    PREPARADO,
    EJECUTANDOSE,
    BLOQUEADO,
    FINALIZADO
}
