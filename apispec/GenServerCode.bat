java --add-opens java.base/java.util=ALL-UNNAMED -jar swagger-codegen-cli-3.0.33.jar generate -i notification_api.yaml -l spring -o notification-api --api-package com.gt.demo.notification.api --model-package com.gt.demo.notification.dto