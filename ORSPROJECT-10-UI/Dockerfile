FROM nginx:alpine

# Copy already-built Angular dist
COPY dist/orsproject-10-ui/ /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]