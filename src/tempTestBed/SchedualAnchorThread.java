package tempTestBed;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SchedualAnchorThread {
    public String schedualAnchor(int anchorId, int sequenceId){
        Map map = new HashMap();
        map.put("anchorId", anchorId); // used for the anchor to fast get the information without any exception handler
        map.put("sequenceId", sequenceId);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }
}
