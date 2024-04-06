BEGIN;

CREATE TABLE IF NOT EXISTS public."coins"
(
    id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    price double precision NOT NULL,
    h1 double precision NOT NULL,
    h24 double precision NOT NULL,
    d7 double precision NOT NULL,
    market_cap double precision NOT NULL,
    volume double precision NOT NULL,
    last_price double precision[] NOT NULL,
    CONSTRAINT "coins_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."deal"
(
    id BIGSERIAL NOT NULL,
    portfolio_id BIGSERIAL NOT NULL,
    date text NOT NULL,
    type text NOT NULL,
    price double precision NOT NULL,
    volume double precision NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    CONSTRAINT "deal_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."coin"
(
    id BIGSERIAL NOT NULL,
    portfolio_id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    volume double precision NOT NULL,
    usd_price double precision NOT NULL,
    last_price double precision[] NOT NULL,
    CONSTRAINT "coin_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."trend"
(
    id BIGSERIAL NOT NULL,
    coin_name text NOT NULL,
    coin_code text NOT NULL,
    h24 double precision NOT NULL,
    CONSTRAINT "trend_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."portfolio"
(
    id BIGSERIAL NOT NULL,
    profile_volume_usd double precision[] NOT NULL,
    profile_volume_btc double precision[] NOT NULL,
    current_volume_usd double precision NOT NULL,
    current_volume_btc double precision NOT NULL,
    CONSTRAINT "portfolio_pkey" PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public."exchanges"
(
    id BIGSERIAL NOT NULL,
    name text NOT NULL,
    score double precision NOT NULL,
    volume24h double precision NOT NULL,
    markets double precision NOT NULL,
    "coins" double precision NOT NULL,
    last_volume double precision[] NOT NULL,
    CONSTRAINT "exchanges_pkey" PRIMARY KEY (id)
);
END;