package com.devskiller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.checkerframework.checker.signature.qual.ClassGetName;

public enum Genre {

	FICTION,
	HORROR,
	COMEDY,
	DRAMA,
	NON_FICTION,
	REALISTIC,
	ROMANTIC,
	TECH,
	TRAGEDY,
	FANTASY;
}