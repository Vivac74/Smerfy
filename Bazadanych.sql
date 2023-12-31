PGDMP                         {           SmerfyDB    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16580    SmerfyDB    DATABASE     }   CREATE DATABASE "SmerfyDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Polish_Poland.1250';
    DROP DATABASE "SmerfyDB";
                postgres    false            �            1259    16589    smurf_statistics    TABLE     �  CREATE TABLE public.smurf_statistics (
    id integer NOT NULL,
    smurf_id integer,
    imie character varying(255),
    wiek integer,
    zdrowie integer,
    poziomglodu integer,
    wioska character varying(255),
    wytrzymalosc integer,
    umiejetnoscispoleczne integer,
    inteligencja integer,
    szczescie integer,
    sila integer,
    zwinnosc integer,
    charyzma integer,
    gotowanie integer
);
 $   DROP TABLE public.smurf_statistics;
       public         heap    postgres    false            �            1259    16588    smurf_statistics_id_seq    SEQUENCE     �   CREATE SEQUENCE public.smurf_statistics_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.smurf_statistics_id_seq;
       public          postgres    false    217            	           0    0    smurf_statistics_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.smurf_statistics_id_seq OWNED BY public.smurf_statistics.id;
          public          postgres    false    216            �            1259    16582    smurfs    TABLE     �   CREATE TABLE public.smurfs (
    id integer NOT NULL,
    imie character varying(255) NOT NULL,
    wiek integer,
    zdrowie numeric(5,2)
);
    DROP TABLE public.smurfs;
       public         heap    postgres    false            �            1259    16581    smurfs_id_seq    SEQUENCE     �   CREATE SEQUENCE public.smurfs_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.smurfs_id_seq;
       public          postgres    false    215            
           0    0    smurfs_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.smurfs_id_seq OWNED BY public.smurfs.id;
          public          postgres    false    214            k           2604    16592    smurf_statistics id    DEFAULT     z   ALTER TABLE ONLY public.smurf_statistics ALTER COLUMN id SET DEFAULT nextval('public.smurf_statistics_id_seq'::regclass);
 B   ALTER TABLE public.smurf_statistics ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            j           2604    16585 	   smurfs id    DEFAULT     f   ALTER TABLE ONLY public.smurfs ALTER COLUMN id SET DEFAULT nextval('public.smurfs_id_seq'::regclass);
 8   ALTER TABLE public.smurfs ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215                      0    16589    smurf_statistics 
   TABLE DATA           �   COPY public.smurf_statistics (id, smurf_id, imie, wiek, zdrowie, poziomglodu, wioska, wytrzymalosc, umiejetnoscispoleczne, inteligencja, szczescie, sila, zwinnosc, charyzma, gotowanie) FROM stdin;
    public          postgres    false    217   �                  0    16582    smurfs 
   TABLE DATA           9   COPY public.smurfs (id, imie, wiek, zdrowie) FROM stdin;
    public          postgres    false    215   �                  0    0    smurf_statistics_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.smurf_statistics_id_seq', 1, false);
          public          postgres    false    216                       0    0    smurfs_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.smurfs_id_seq', 1, false);
          public          postgres    false    214            o           2606    16595 &   smurf_statistics smurf_statistics_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.smurf_statistics
    ADD CONSTRAINT smurf_statistics_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.smurf_statistics DROP CONSTRAINT smurf_statistics_pkey;
       public            postgres    false    217            m           2606    16587    smurfs smurfs_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.smurfs
    ADD CONSTRAINT smurfs_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.smurfs DROP CONSTRAINT smurfs_pkey;
       public            postgres    false    215            p           2606    16596 /   smurf_statistics smurf_statistics_smurf_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.smurf_statistics
    ADD CONSTRAINT smurf_statistics_smurf_id_fkey FOREIGN KEY (smurf_id) REFERENCES public.smurfs(id);
 Y   ALTER TABLE ONLY public.smurf_statistics DROP CONSTRAINT smurf_statistics_smurf_id_fkey;
       public          postgres    false    215    3181    217                  x������ � �             x������ � �     