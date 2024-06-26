create table if not exists compilations (
    id bigint generated by default as identity not null primary key,
    title varchar(50) not null,
    pinned boolean default false
);

create table if not exists users (
    id bigint generated by default as identity not null primary key,
    name varchar(250) not null,
    email varchar(254) not null unique
);

create table if not exists categories (
    id bigint generated by default as identity not null primary key,
    name varchar(50) not null unique
);

create table if not exists events (
    id bigint generated by default as identity not null primary key,
    annotation varchar(2000) not null,
    category_id bigint not null references categories(id),
    confirmed_requests integer,
    created timestamp not null,
    description varchar(7000) not null,
    state_action varchar(20) not null,
    event_date timestamp not null,
    initiator_id bigint not null references users(id),
    paid boolean not null default false,
    participant_limit bigint default 0,
    published timestamp,
    request_moderation boolean not null default false,
    state varchar(20) not null,
    title varchar(120) not null,
    views bigint,
    lat real,
    lon real,
    compilation_id bigint references compilations(id)
);

create table if not exists event_participation_requests (
    id bigint generated by default as identity not null primary key,
    event_id bigint not null references events(id),
    requester_id bigint not null references users(id),
    created timestamp not null default(CURRENT_TIMESTAMP),
    status varchar(20) not null
);

create table if not exists comments (
    id bigint generated by default as identity not null primary key,
    event_id bigint not null references events(id),
    author_id bigint not null references users(id),
    text varchar(2000) not null,
    created timestamp not null,
    edited timestamp
);