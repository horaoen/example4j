/*
 * This file is generated by jOOQ.
 */
package com.horaoen.example4j.jooq.database.tables;


import com.horaoen.example4j.jooq.database.Keys;
import com.horaoen.example4j.jooq.database.Library;
import com.horaoen.example4j.jooq.database.tables.records.AuthorRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author extends TableImpl<AuthorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>library.author</code>
     */
    public static final Author AUTHOR = new Author();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorRecord> getRecordType() {
        return AuthorRecord.class;
    }

    /**
     * The column <code>library.author.id</code>.
     */
    public final TableField<AuthorRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>library.author.first_name</code>.
     */
    public final TableField<AuthorRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>library.author.last_name</code>.
     */
    public final TableField<AuthorRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(255), this, "");

    private Author(Name alias, Table<AuthorRecord> aliased) {
        this(alias, aliased, null);
    }

    private Author(Name alias, Table<AuthorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>library.author</code> table reference
     */
    public Author(String alias) {
        this(DSL.name(alias), AUTHOR);
    }

    /**
     * Create an aliased <code>library.author</code> table reference
     */
    public Author(Name alias) {
        this(alias, AUTHOR);
    }

    /**
     * Create a <code>library.author</code> table reference
     */
    public Author() {
        this(DSL.name("author"), null);
    }

    public <O extends Record> Author(Table<O> child, ForeignKey<O, AuthorRecord> key) {
        super(child, key, AUTHOR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Library.LIBRARY;
    }

    @Override
    public UniqueKey<AuthorRecord> getPrimaryKey() {
        return Keys.KEY_AUTHOR_PRIMARY;
    }

    @Override
    public Author as(String alias) {
        return new Author(DSL.name(alias), this);
    }

    @Override
    public Author as(Name alias) {
        return new Author(alias, this);
    }

    @Override
    public Author as(Table<?> alias) {
        return new Author(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(String name) {
        return new Author(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Name name) {
        return new Author(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Table<?> name) {
        return new Author(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
