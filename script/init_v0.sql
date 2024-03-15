-- Insertion de données initiales si nécessaire
-- INSERT INTO authentication.T_USER_USR (USR_UUID, USR_EMAIL, USR_PASSWORD, USR_ENABLED) VALUES ('...', '...', '...', TRUE);
INSERT INTO authentication.T_ROLE_RLE (RLE_ROLENAME) VALUES ('ROLE_USER');
INSERT INTO authentication.T_ROLE_RLE (RLE_ROLENAME) VALUES ('ROLE_ADMIN');
-- INSERT INTO authentication.TA_ROLE_USER_RLU (USR_UUID, RLE_ID) VALUES ('...', ...);