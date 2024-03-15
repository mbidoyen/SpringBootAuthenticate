-- Supprimer la base de données si elle existe
DROP DATABASE IF EXISTS spring_authentication;

-- Créer la base de données
CREATE DATABASE spring_authentication;

-- Utiliser la base de données nouvellement créée
\c spring_authentication;

-- Créer le schéma authentication
DROP SCHEMA IF EXISTS authentication CASCADE;
CREATE SCHEMA IF NOT EXISTS authentication;

-- Créer la table T_USER_USR
CREATE TABLE IF NOT EXISTS authentication.T_USER_USR (
    USR_ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    USR_EMAIL VARCHAR(255) NOT NULL UNIQUE,
    USR_PASSWORD VARCHAR(255) NOT NULL,
    USR_ENABLED BOOLEAN NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Créer la table T_ROLE_RLE
CREATE TABLE IF NOT EXISTS authentication.T_ROLE_RLE (
    RLE_ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    RLE_ROLENAME VARCHAR(255) NOT NULL UNIQUE,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Créer la table TA_ROLE_USER_RLU
CREATE TABLE IF NOT EXISTS authentication.TA_ROLE_USER_RLU (
    USR_ID UUID,
    RLE_ID UUID,
    PRIMARY KEY (USR_ID, RLE_ID),
    FOREIGN KEY (USR_ID) REFERENCES authentication.T_USER_USR(USR_ID),
    FOREIGN KEY (RLE_ID) REFERENCES authentication.T_ROLE_RLE(RLE_ID)
);


