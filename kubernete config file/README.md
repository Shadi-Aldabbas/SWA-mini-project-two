first create .jar file using "mvc clean package -DSkipTests"
then make sure that minikube is started 
then for each service directory run "& minikube -p minikube docker-env --shell powershell | Invoke-Expression" on powershell
then build docker file in minikube docker using "docker build --tag=<service-name>:<tag> ."
then go to kubernate config file and run "kubectl apply -f ./" on powershell
then download kube-forward app from "https://github.com/pixel-point/kube-forwarder"
the rest are more like steps I will explain in video

Thanks,
done By Shadi Aldabbas (613831), Arda Agcal (613802) and Ahmad Abdeen (613850)