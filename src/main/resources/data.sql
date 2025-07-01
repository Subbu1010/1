INSERT INTO sec_lkp_role (role_id, role_nm, role_desc, ad_grp, rec_ord, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
('ADMIN', 'Administrator', 'System Admin', 'AD_ADMIN', 1, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('USER', 'User', 'Regular User', 'AD_USER', 2, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('GUEST', 'Guest', 'Guest User', 'AD_GUEST', 3, '2023-01-01', '2024-12-31', 'SYS', '2023-01-01', 'SYS', '2023-01-01');

INSERT INTO sec_lkp_chan (chan_id, chan_nm, ad_grp, rec_ord, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
('WEB', 'Web Channel', 'AD_WEB', 1, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('MOBILE', 'Mobile Channel', 'AD_MOBILE', 2, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01');

INSERT INTO sec_lkp_aud_lvl (aud_lvl_id, aud_lvl_nm, ad_grp, appvr_soeid, appvr_fname, appvr_lname, appvr_grp, resr_id, rec_ord, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
('AL1', 'Audit Level 1', 'AD_AUD1', 'SOEID1', 'John', 'Doe', 'GRP1', 'RES1', 1, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('AL2', 'Audit Level 2', 'AD_AUD2', 'SOEID2', 'Jane', 'Smith', 'GRP2', 'RES2', 2, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01');

INSERT INTO sec_lkp_perms_cat (perms_cat_id, perms_cat_nm, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
(1, 'Category1', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
(2, 'Category2', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01');

INSERT INTO sec_lkp_perms (perms_cat_id, perms_id, perms_nm, ad_grp, rec_ord, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
(1, 'PERM1', 'Permission 1', 'AD_PERM1', 1, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
(1, 'PERM2', 'Permission 2', 'AD_PERM2', 2, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
(2, 'PERM3', 'Permission 3', 'AD_PERM3', 1, '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01');

INSERT INTO sec_lkp_role_perms (role_id, perms_id, def_flag, actvd_dt, deprecated_dt, created_by, created_on, updated_by, updated_on) VALUES
('ADMIN', 'PERM1', 'Y', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('ADMIN', 'PERM2', 'Y', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('USER', 'PERM2', 'N', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'),
('USER', 'PERM3', 'N', '2023-01-01', NULL, 'SYS', '2023-01-01', 'SYS', '2023-01-01'); 