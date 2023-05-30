importScripts('workbox-sw.js');

const HTML_CACHE = "relive-sim-html";
const JS_CACHE = "relive-sim-javascript";
const STYLE_CACHE = "relive-sim-stylesheets";
const IMAGE_CACHE = "relive-sim-images";
const FONT_CACHE = "relive-sim-fonts";

self.addEventListener("message", (event) => {
  if (event.data && event.data.type === "SKIP_WAITING") {
    self.skipWaiting();
  }
});

workbox.precaching.precacheAndRoute([
// Generated Precache Entries (Do Not Remove)
], {
  ignoreURLParametersMatching: [/.*/]
})

workbox.routing.registerRoute(
  ({event}) => event.request.destination === 'document',
  new workbox.strategies.NetworkFirst({
    cacheName: HTML_CACHE,
    plugins: [],
  })
);

workbox.routing.registerRoute(
    ({event}) => event.request.destination === 'script',
    new workbox.strategies.NetworkFirst({
        cacheName: JS_CACHE,
        plugins: [],
    })
);

workbox.routing.registerRoute(
  ({event}) => event.request.destination === 'style',
  new workbox.strategies.NetworkFirst({
    cacheName: STYLE_CACHE,
    plugins: [],
  })
);

workbox.routing.registerRoute(
  ({event}) => event.request.destination === 'image',
  new workbox.strategies.CacheFirst({
    cacheName: IMAGE_CACHE,
    plugins: [],
  })
);

workbox.routing.registerRoute(
  ({event}) => event.request.destination === 'font',
  new workbox.strategies.StaleWhileRevalidate({
    cacheName: FONT_CACHE,
    plugins: [],
  })
);
