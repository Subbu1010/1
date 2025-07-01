CREATE TABLE sec_lkp_role (
    role_id VARCHAR(50) PRIMARY KEY,
    role_nm VARCHAR(50),
    role_desc VARCHAR(255),
    ad_grp VARCHAR(100),
    rec_ord INTEGER,
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
);

CREATE TABLE sec_lkp_chan (
    chan_id VARCHAR(50) PRIMARY KEY,
    chan_nm VARCHAR(50),
    ad_grp VARCHAR(100),
    rec_ord INTEGER,
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
);

CREATE TABLE sec_lkp_aud_lvl (
    aud_lvl_id VARCHAR(30) PRIMARY KEY,
    aud_lvl_nm VARCHAR(30),
    ad_grp VARCHAR(100),
    appvr_soeid VARCHAR(10),
    appvr_fname VARCHAR(50),
    appvr_lname VARCHAR(50),
    appvr_grp VARCHAR(100),
    resr_id VARCHAR(30),
    rec_ord INTEGER,
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
);

CREATE TABLE sec_lkp_perms_cat (
    perms_cat_id INTEGER PRIMARY KEY,
    perms_cat_nm VARCHAR(30),
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
);

CREATE TABLE sec_lkp_perms (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    perms_cat_id INTEGER,
    perms_id VARCHAR(50),
    perms_nm VARCHAR(50),
    ad_grp VARCHAR(100),
    rec_ord INTEGER,
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
);

CREATE TABLE sec_lkp_role_perms (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    role_id VARCHAR(50),
    perms_id VARCHAR(50),
    def_flag VARCHAR(10),
    actvd_dt DATE,
    deprecated_dt DATE,
    created_by VARCHAR(10),
    created_on DATE,
    updated_by VARCHAR(10),
    updated_on DATE
); 