# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

import redis

r = redis.StrictRedis(host='localhost', port=6379, db=0)

class Movie(object):
    def __init__(self, title=None, actors=None):
        self.title = title
        self.actors = actors

# Create your views here.

def index(request):
    if request.method == 'POST':
        keys = r.keys("movies:" + movie_title)
        movieslist = []
        for key in keys:
            movieslist.append(Movie(key, r.hgetall(key)))
        return render(request, 'movies/index.html', {'movies': movieslist})
    else:
        keys = r.keys("movies:*")
        movieslist = []
        for key in keys:
            movieslist.append(Movie(key, r.hgetall(key)))
        return render(request, 'movies/index.html', {'movies': movieslist})
        
def movie(request, movie_title):
    keys = r.keys("movies:" + movie_title)
    keys = r.keys("movies:" + movie_title)
    movieslist = []
    for key in keys:
            movieslist.append(Movie(key, r.hgetall(key)))
    return render(request, 'movies/index.html', {'movies': movieslist})