function [] = sleepdetection(emailaddress)
    
    % Create video input object
    vid = videoinput('winvideo');

    % Detector Objects
     faceDetector = vision.CascadeObjectDetector();
     faceDetector.MinSize = [120 120];
     faceDetector.MergeThreshold = 6;
     eyeDetector = vision.CascadeObjectDetector('LeftEye');
     eyeDetector.MergeThreshold = 18;
    cam = webcam
    h = figure,;
    
    % Calculating sleep probability
    sleepframes = 10;
    sleeptable = zeros(sleepframes,2);
    issleeping = 0;
    
    mailframes = 50;
    mailtable = zeros(mailframes,1);
    mailsum = 0;
    mailthreshold = 0.8;

    
    while (ishandle(h) == 1)
        img = snapshot(cam);
        fbb = step(faceDetector, img); % x y width height
        fbb = faceDetection(fbb);
        fbbsize = size(fbb);

        if(fbbsize(1) > 0 & fbb ~= 0 & ~isempty(fbb))
            ebb = step(eyeDetector, img);
            ebbsize = size(ebb);

            if(ebb ~= 0 & ~isempty(ebb))
                count = 1;
                C = zeros(2,4);
                for (i = 1:ebbsize(1))
                   if ((ebb(i,2) + ebb(i,4)/2) < (fbb(2) + fbb(4)/2)) & ( ebb(i,1) < fbb(1) + fbb(4) ) & (ebb(i,1) > fbb(1)) && (ebb(i,2) > fbb(2))
                       C(count,:) = ebb(i,:);
                       C(count,:) = [round(ebb(i,1) + ebb(i,3) * 0.1), round(ebb(i,2) + ebb(i,4) * 0.15), round(ebb(i,3) * 0.8), round(ebb(i,4) * 0.85)];
                       count = count + 1;
                   end
                end
                fimg = imcrop(img, fbb(1,:));
                e1img = imcrop(img,C(1,:));
                e2img = imcrop(img,C(2,:));
%                 subplot(2,4,1), imshow(img);
%                 subplot(2,4,2), imshow(fimg);
%                 subplot(2,4,3), imshow(e1img);
%                 subplot(2,4,4), imshow(e2img);
                e1img1 = eyeDetection(e1img);
                e2img1 = eyeDetection(e2img);
%                 subplot(2,4,5), imshow(e1img1)
%                 subplot(2,4,6), imshow(e2img1)
    %             e1 = openclose(e1img1, 0.18)
    %             e2 = openclose(e2img1, 0.18)
                position = [0,0];
                if issleeping == 0
                    img1 = insertText(img,position,'Awake');
                end
                if issleeping == 1
                    img1 = insertText(img,position,'Sleeping');
                end
                if issleeping == 2
                    img1 = insertText(img,position,'Face Not Detected');
                end
                try
                    imshow(img1);
                catch
                end

            end
        

        % Calculating sleeping probability
        sleeptable(2:sleepframes,:) = sleeptable(1:sleepframes-1,:);
        sleeptable(1,1) = openclose(e1img1, 0.18);
        sleeptable(1,2) = openclose(e2img1, 0.18);
        sleepsum = sum(sleeptable);
        sleepsum = sum(sleepsum);
        if sleepsum > sleepframes * 2 * 0.2
            issleeping = 1; %asleep
        end
        if sleepsum <= sleepframes * 2 * 0.2
            issleeping = 0; %awake
        end
        if fbb == 0
           issleeping = 2; %face not detected
        end
        
        if issleeping ~= 2
            mailtable (2:mailframes,1) = mailtable (1:mailframes-1,1);
            mailtable(1,1) = issleeping;
            mailsum = sum(mailtable);
            if mailsum > mailframes * mailthreshold
                matlabmail('6476296228@vmobile.ca', 'WAKE UP!');
%                 matlabmail(emailaddress, 'WAKE UP!') %'6478584565@vmobile.ca'
                mailsum = 0;
                mailtable = zeros(mailframes,1); 
            end
        end
    end
end
    if ishandle(h) == 0
        delete(vid)
        delete(cam)
    end
end