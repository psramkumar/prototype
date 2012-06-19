package com.vzb.prj.err;

public class ErrorDescriptions   {
    public static final String GeneralException =                       "10000=1,The server has encountered an internal error which prevents it from fulfilling your request. Please contact the system administrator.";
    public static final String FileNotFound =                           "10010=1,Could not find file named %.";
    public static final String FileReadError =                          "10020=1,Could not read file named %.";
    public static final String DBConnectionFailure =                    "10030=1,Could not connect to database %.";
    public static final String ErrorExecutingSQLStatement =             "10040=1,Error excuting SQL statement: %.";
    public static final String GenericJavaException =                   "10050=1,The server encountered the following Exception: %";
    public static final String GenericSQLException =                    "10060=1,The server encountered the following SQLException: %";
    public static final String NamingException =                        "10070=1,The server could not locate the Home Interface : %";
    public static final String AuthenticationFailure =                  "20000=1,The server could not authenticate the user : %";
    public static final String SendMailFailure =                        "40004=2,Email Sending Failed : % ";
    public static final String TemplateMailFailure =                    "40005=2,Template Email Formattting Failed : % %";
 }