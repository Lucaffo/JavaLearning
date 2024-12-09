# Step 1: Costruzione dell'app con Node.js
FROM node:18-alpine AS builder

# Cartella di lavoro
WORKDIR /app

# Copia package.json e package-lock.json per installare le dipendenze
COPY package*.json ./

# Installa le dipendenze
RUN npm install

# Copia i file del progetto e costruisci
COPY . .
RUN npm run build

# Step 2: Servire il build con NGINX
FROM nginx:alpine

# Copia i file di build nella directory di NGINX
COPY --from=builder /app/build /usr/share/nginx/html

# Espone la porta 80
EXPOSE 80

# Avvia NGINX
CMD ["nginx", "-g", "daemon off;"]