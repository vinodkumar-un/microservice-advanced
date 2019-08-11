create table oauth_client_details (
  client_id VARCHAR2(256) PRIMARY KEY,
  resource_ids VARCHAR2(256),
  client_secret VARCHAR2(256),
  scope VARCHAR2(256),
  authorized_grant_types VARCHAR2(256),
  web_server_redirect_uri VARCHAR2(256),
  authorities VARCHAR2(256),
  access_token_validity number(11),
  refresh_token_validity number(11),
  additional_information VARCHAR2(256),
  autoapprove VARCHAR2(256)
);

create table oauth_client_token (
  token_id VARCHAR2(256),
  token blob,
  authentication_id VARCHAR2(256) PRIMARY KEY,
  user_name VARCHAR2(256),
  client_id VARCHAR2(256)
);

create table oauth_access_token (
  token_id VARCHAR2(256),
  token blob,
  authentication_id VARCHAR2(256) PRIMARY KEY,
  user_name VARCHAR2(256),
  client_id VARCHAR2(256),
  authentication blob,
  refresh_token VARCHAR2(256)
);

create table oauth_refresh_token (
  token_id VARCHAR2(256),
  token blob,
  authentication blob
);

create table oauth_code (
  code VARCHAR2(256), authentication blob
);

create table oauth_approvals (
    userId VARCHAR2(256),
    clientId VARCHAR2(256),
    scope VARCHAR2(256),
    status VARCHAR2(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

INSERT INTO oauth_client_details
    (client_id, resource_ids, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
    additional_information, autoapprove)
VALUES
    ('clientapp', null, '123456',
    'read_profile,read_posts', 'authorization_code',
    'http://localhost:9000/callback',
    null, 3000, -1, null, 'false');