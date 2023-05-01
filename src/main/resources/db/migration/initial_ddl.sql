CREATE DATABASE memorycard;
CREATE USER carduser WITH ENCRYPTED PASSWORD 'carduser';
GRANT ALL PRIVILEGES ON DATABASE memorycard TO carduser;

alter user carduser with superuser;

alter user carduser with createdb;

alter user carduser with createrole;

alter user carduser with replication;

alter user carduser with bypassrls;